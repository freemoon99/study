import 'package:flutter/material.dart';
import 'package:flutter/services.dart' show rootBundle;
import 'package:http/src/client.dart';
import 'package:web3dart/web3dart.dart';

class Note {
  String title;
  String content;

  Note({
    required this.title,
    required this.content,
  });
}

class NoteApp extends StatefulWidget {
  const NoteApp({super.key});

  @override
  _NoteAppState createState() => _NoteAppState();
}

class _NoteAppState extends State<NoteApp> {
  List<Note> notes = [];
  late Client httpClient;
  late Web3Client ethClient;

  late EthereumAddress contractAddress;
  late DeployedContract contract;
  late ContractFunction createNoteFunction;
  late ContractFunction getNoteCountFunction;
  late ContractFunction getNoteByIndexFunction;
  late ContractFunction updateNoteByIndexFunction;
  late ContractFunction deleteNoteByIndexFunction;
  late int noteCount;

  EthPrivateKey credentials = EthPrivateKey.fromHex("메타마스크 개인 키");

  @override
  void initState() {
    super.initState();
    connectToEthereum();
    httpClient = Client();
    ethClient = Web3Client("https://sepolia.infura.io/v3/개인인푸라주소", httpClient);
  }

  Future<void> connectToEthereum() async {
    String abiJson = await rootBundle.loadString('assets/abi.json');
    String contractAddress = "개인 스마트컨트랙드 주소";

    contract = DeployedContract(ContractAbi.fromJson(abiJson, 'ContractName'),
        EthereumAddress.fromHex(contractAddress));

    createNoteFunction = contract.function('createNote');
    getNoteCountFunction = contract.function('getNoteCount');
    getNoteByIndexFunction = contract.function('getNoteByIndex');
    updateNoteByIndexFunction = contract.function('updateNoteByIndex');
    deleteNoteByIndexFunction = contract.function('deleteNoteByIndex');

    await fetchNotesFromContract();
  }

  Future<void> fetchNotesFromContract() async {
    final List<dynamic> result = await ethClient.call(
      contract: contract,
      function: getNoteCountFunction,
      params: [],
    );

    noteCount = result[0].toInt();
    notes.clear();

    for (int i = 0; i < noteCount; i++) {
      final List<dynamic> noteResult = await ethClient.call(
        contract: contract,
        function: getNoteByIndexFunction,
        params: [BigInt.from(i)],
      );

      final title = noteResult[0].toString();
      final content = noteResult[1].toString();

      notes.add(Note(
        title: title,
        content: content,
      ));
    }

    setState(() {});
  }

  Future<void> createNote(String title, String content) async {
    await ethClient.sendTransaction(
      credentials,
      Transaction.callContract(
        contract: contract,
        function: createNoteFunction,
        parameters: [title, content],
      ),
      chainId: 11155111,
    );

    await fetchNotesFromContract();
  }

  Future<void> updateNoteByIndex(
      int index, String title, String content) async {
    await ethClient.sendTransaction(
      credentials,
      Transaction.callContract(
        contract: contract,
        function: updateNoteByIndexFunction,
        parameters: [BigInt.from(index), title, content],
      ),
      chainId: 11155111,
    );

    await fetchNotesFromContract();
  }

  Future<void> deleteNoteByIndex(int index) async {
    if (index >= 0 && index < notes.length) {
      await ethClient.sendTransaction(
        credentials,
        Transaction.callContract(
          contract: contract,
          function: deleteNoteByIndexFunction,
          parameters: [BigInt.from(index)],
        ),
        chainId: 11155111,
      );

      // 트랜잭션이 성공적으로 전송된 경우에만 업데이트하도록 확인
      await fetchNotesFromContract();
    } else {
      print('Invalid index');
    }
  }

  Future<void> createNoteDialog() async {
    final TextEditingController titleController = TextEditingController();
    final TextEditingController contentController = TextEditingController();

    await showDialog(
      context: context,
      builder: (context) {
        return AlertDialog(
          title: const Text('Create Note'),
          content: Column(
            children: [
              TextField(
                controller: titleController,
                decoration: const InputDecoration(labelText: 'Title'),
              ),
              TextField(
                controller: contentController,
                decoration: const InputDecoration(labelText: 'Content'),
              ),
            ],
          ),
          actions: [
            TextButton(
              child: const Text('Cancel'),
              onPressed: () => Navigator.of(context).pop(),
            ),
            TextButton(
              child: const Text('Create'),
              onPressed: () {
                final title = titleController.text;
                final content = contentController.text;
                createNote(title, content);
                Navigator.of(context).pop();
              },
            ),
          ],
        );
      },
    );
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text('Note App'),
      ),
      body: ListView.builder(
        itemCount: notes.length,
        itemBuilder: (context, index) {
          final note = notes[index];
          return ListTile(
            title: Text(note.title),
            subtitle: Text(note.content),
            trailing: IconButton(
              icon: const Icon(Icons.delete),
              onPressed: () => deleteNoteByIndex(index),
            ),
            onTap: () => updateNoteDialog(index),
          );
        },
      ),
      floatingActionButton: FloatingActionButton(
        onPressed: createNoteDialog,
        child: const Icon(Icons.add),
      ),
    );
  }

  Future<void> updateNoteDialog(int index) async {
    final TextEditingController titleController =
        TextEditingController(text: notes[index].title);
    final TextEditingController contentController =
        TextEditingController(text: notes[index].content);

    await showDialog(
      context: context,
      builder: (context) {
        return AlertDialog(
          title: const Text('Update Note'),
          content: Column(
            children: [
              TextField(
                controller: titleController,
                decoration: const InputDecoration(labelText: 'Title'),
              ),
              TextField(
                controller: contentController,
                decoration: const InputDecoration(labelText: 'Content'),
              ),
            ],
          ),
          actions: [
            TextButton(
              child: const Text('Cancel'),
              onPressed: () => Navigator.of(context).pop(),
            ),
            TextButton(
              child: const Text('Update'),
              onPressed: () {
                final title = titleController.text;
                final content = contentController.text;
                updateNoteByIndex(index, title, content);
                Navigator.of(context).pop();
              },
            ),
          ],
        );
      },
    );
  }
}
