import 'package:flutter/material.dart';

exibirAlerta({context, titulo, content}) {
  showDialog(
    context: context,
    builder: (BuildContext context) {
      return AlertDialog(
        title: Center(
          child: Text(
            titulo,
            style: TextStyle(
                color: Color.fromRGBO(243, 6, 6, 1.0),
                fontWeight: FontWeight.bold),
          ),
        ),
        content: Text(content,
            style: TextStyle(
                color: Color.fromRGBO(15, 137, 141, 1.0),
                fontWeight: FontWeight.bold)),
        actions: [
          TextButton(
              onPressed: () {
                Navigator.pop(context);
              },
              child: Text('Fechar')),
        ],
      );
    },
  );
}
