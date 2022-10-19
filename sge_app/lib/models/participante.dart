import 'package:flutter/material.dart';
import 'package:sge_app/models/pagamento.dart';

import 'evento.dart';

class Participante extends ChangeNotifier{

  int _id;
  String _nome;
  DateTime _dataNascimento;
  String _email;
  bool _status;
  String _telefone;
  Pagamento _pagamento;
  Evento _evento;

  int get id => _id;

  set id(int value) {
    _id = value;
  }

  String get nome => _nome;

  set nome(String value) {
    _nome = value;
  }

  Evento get evento => _evento;

  set evento(Evento value) {
    _evento = value;
  }

  Pagamento get pagamento => _pagamento;

  set pagamento(Pagamento value) {
    _pagamento = value;
  }

  String get telefone => _telefone;

  set telefone(String value) {
    _telefone = value;
  }

  bool get status => _status;

  set status(bool value) {
    _status = value;
  }

  String get email => _email;

  set email(String value) {
    _email = value;
  }

  DateTime get dataNascimento => _dataNascimento;

  set dataNascimento(DateTime value) {
    _dataNascimento = value;
  }

  Participante(this._id, this._nome, this._dataNascimento, this._email,
      this._status, this._telefone, this._pagamento, this._evento);

  Map<String, dynamic> mapJson(){
    return{
    'nome':_nome,
    'dataNascimento':_dataNascimento,
    'email':_email,
    'status':_status,
    'telefone':_telefone,
    'pagamento':_pagamento,
    'evento':_evento,
    };

  }
}