import 'package:flutter/material.dart';

class Motivo extends ChangeNotifier{

  int _id;
  String _titulo;
  String _decricao;

  int get id => _id;

  String get titulo => _titulo;

  String get decricao => _decricao;

  set decricao(String value) {
    _decricao = value;
  }

  set titulo(String value) {
    _titulo = value;
  }

  set id(int value) {
    _id = value;
  }

  Motivo(this._id, this._titulo, this._decricao);
}