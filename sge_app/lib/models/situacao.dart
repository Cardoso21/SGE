import 'package:flutter/material.dart';

class Situacao extends ChangeNotifier{

  int _id;
  String _descricao;

  int get id => _id;

  set id(int value) {
    _id = value;
  }

  String get descricao => _descricao;

  set descricao(String value) {
    _descricao = value;
  }

  Situacao(this._id, this._descricao);
}