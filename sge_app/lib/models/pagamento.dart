import 'package:flutter/material.dart';

class Pagamento extends ChangeNotifier{

  int _id;
  String _decricao;

  int get id => _id;

  set id(int value) {
    _id = value;
  }

  String get decricao => _decricao;

  set decricao(String value) {
    _decricao = value;
  }

  Pagamento(this._id, this._decricao);

  Map<String, dynamic> mapJson() {
    return {
      'descricao': _decricao
    };
  }
}