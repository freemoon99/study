import 'package:flutter/material.dart';

class Calculator extends StatefulWidget {
  @override
  State<Calculator> createState() => _CalculatorState();
}

class _CalculatorState extends State<Calculator> {
  String userInput = "";
  String result = "0";

  List<String> buttonList = [
    'C',
    '(',
    ')',
    '/',
    '7',
    '8',
    '9',
    '*',
    '4',
    '5',
    '6',
    '+',
    '1',
    '2',
    '3',
    '-',
    'AC',
    '0',
    '.',
    '=',
  ];

  @override
  Widget build(BuildContext context) {
    return SafeArea(
      child: Scaffold(
        body: Column(
          children: [
            Flexible(
              child: resultWidget(),
              flex: 1,
            ),
            Flexible(
              child: buttonWidget(),
              flex: 3,
            ),
          ],
        ),
      ),
    );
  }

  Widget resultWidget() {
    return Column(
      children: [
        Container(
          padding: const EdgeInsets.all(20),
          alignment: Alignment.centerRight,
          child: Text(
            userInput,
            style: const TextStyle(fontSize: 32),
          ),
        ),
        Container(
          padding: const EdgeInsets.all(20),
          alignment: Alignment.centerRight,
          child: Text(
            result,
            style: const TextStyle(fontSize: 48, fontWeight: FontWeight.bold),
          ),
        )
      ],
    );
  }

  Widget buttonWidget() {
    return GridView.builder(
      itemCount: buttonList.length,
      gridDelegate:
          const SliverGridDelegateWithFixedCrossAxisCount(crossAxisCount: 4),
      itemBuilder: (BuildContext context, int index) {
        return button(buttonList[index]);
      },
    );
  }

  Widget button(String text) {
    return Container(
      margin: const EdgeInsets.all(10),
      child: MaterialButton(
        onPressed: () {
          setState(() {
            hadndleButtonPress(text);
          });
        },
        color: getColor(text),
        textColor: Colors.white,
        child: Text(
          text,
          style: const TextStyle(fontSize: 25),
        ),
        shape: RoundedRectangleBorder(borderRadius: BorderRadius.circular(10)),
      ),
    );
  }

  hadndleButtonPress(String text) {
    userInput = userInput + text;

    if (text == "AC") {
      userInput = "";
      result = "0";
      return;
    }
    if (text == "C") {
      userInput = userInput.substring(0, userInput.length - 1);
      return;
    }
    if (text == "=") {
      //초반에 string으로 선언했기에 숫자형 -> 문자형으로 바꿔줘야함
      result = calculate(userInput).toString();
      if (result.endsWith(".0")) result = result.replaceAll(".0", "replace");
      userInput = result;
    }
  }

  calculate(ele) {
    if (ele.contains('+')) {
      String element = ele;
      List<String> result1 = element.split('+');
      result1.remove('+');

      var res = int.parse(result1[0]) +
          int.parse(result1[1].substring(0, result1[1].length - 1));

      return res;
    }
    if (ele.contains('-')) {
      String element = ele;
      List<String> result1 = element.split('-');
      result1.remove('-');

      var res = int.parse(result1[0]) -
          int.parse(result1[1].substring(0, result1[1].length - 1));

      return res;
    }
    if (ele.contains('*')) {
      String element = ele;
      List<String> result1 = element.split('*');
      result1.remove('*');

      var res = int.parse(result1[0]) *
          int.parse(result1[1].substring(0, result1[1].length - 1));

      return res;
    }
    if (ele.contains('/')) {
      String element = ele;
      List<String> result1 = element.split('/');
      result1.remove('/');

      var res = int.parse(result1[0]) /
          int.parse(result1[1].substring(0, result1[1].length - 1));

      return res;
    }

    return result;
    // return res.toString();
  }

  getColor(String text) {
    if (text == "/" ||
        text == "*" ||
        text == "+" ||
        text == "-" ||
        text == "=") {
      return Colors.orangeAccent;
    }
    if (text == "C" || text == "AC") {
      return Colors.red;
    }
    if (text == "(" || text == ")") {
      return Colors.blueGrey;
    }
    return Colors.lightBlue;
  }
}
