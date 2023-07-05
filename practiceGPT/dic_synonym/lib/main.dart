import 'dart:convert';
import 'package:flutter/material.dart';
import 'package:flutter/services.dart';
import 'package:http/http.dart' as http;

const apikey = 'api링크';
const apiurl = 'https://api.openai.com/v1/completions';

void main() {
  runApp(const MyApp());
}

Future<String> generateText(String prompt) async {
  final response = await http.post(
    Uri.parse(apiurl),
    headers: {
      'Content-Type': 'application/json',
      'Authorization': 'Bearer $apikey'
    },
    body: jsonEncode({
      "model": "text-davinci-003",
      'prompt': '$prompt 동의어 목록으로 5개만 알려줘',
      'max_tokens': 1000,
      'temperature': 0,
      'top_p': 1,
      'frequency_penalty': 0,
      'presence_penalty': 0
    }),
  );

  Map<String, dynamic> newresponse =
      jsonDecode(utf8.decode(response.bodyBytes));

  return newresponse['choices'][0]['text'];
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    return const MaterialApp(
      home: FirstPage(),
    );
  }
}

class FirstPage extends StatefulWidget {
  const FirstPage({super.key});

  @override
  State<FirstPage> createState() => _FirstPageState();
}

class _FirstPageState extends State<FirstPage> {
  final TextEditingController _controller = TextEditingController();
  late Future<String> _data;

  @override
  void initState() {
    super.initState();
    _data = Future.value("");
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text('동의어 검색 사전'),
      ),
      body: Padding(
        padding: const EdgeInsets.all(16.0),
        child: Column(
          crossAxisAlignment: CrossAxisAlignment.start,
          children: [
            TextField(
              controller: _controller,
              decoration: const InputDecoration(hintText: '검색어를 입력해주세요'),
              inputFormatters: <TextInputFormatter>[
                FilteringTextInputFormatter.allow(RegExp(
                    r'[a-z|A-Z|0-9|ㄱ-ㅎ|ㅏ-ㅣ|가-힣|ᆞ|ᆢ|ㆍ|ᆢ|ᄀᆞ|ᄂᆞ|ᄃᆞ|ᄅᆞ|ᄆᆞ|ᄇᆞ|ᄉᆞ|ᄋᆞ|ᄌᆞ|ᄎᆞ|ᄏᆞ|ᄐᆞ|ᄑᆞ|ᄒᆞ]'))
              ],
            ),
            ElevatedButton(
              onPressed: () async {
                setState(() {
                  _data = generateText(_controller.text.trim());
                });
              },
              child: const Text('검색 결과 확인하기'),
            ),
            const SizedBox(height: 10),
            FutureBuilder<String>(
              future: _data,
              builder: (context, snapshot) {
                if (snapshot.connectionState == ConnectionState.waiting) {
                  return const Center(child: CircularProgressIndicator());
                } else if (snapshot.hasError) {
                  return Text('Error: ${snapshot.error}');
                } else {
                  return Text('${snapshot.data}');
                }
              },
            ),
          ],
        ),
      ),
    );
  }
}
