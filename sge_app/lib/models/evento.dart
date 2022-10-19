import 'package:flutter/material.dart';
import 'package:sge_app/models/participante.dart';
import 'package:sge_app/models/situacao.dart';

import 'motivo.dart';

class Evento extends ChangeNotifier{

  int _id;
  DateTime _dataEvento;
  String _justificativaAdiantamento;
  int _valor;
  Motivo _motivo;
  Situacao _situacao;
  List<Participante> _participante;

  int get id => _id;

  DateTime get dataEvento => _dataEvento;

  String get justificativaAdiantamento => _justificativaAdiantamento;

  int get valor => _valor;

  Motivo get motivo => _motivo;

  Situacao get situacao => _situacao;

  List<Participante> get participante => _participante;

  set participante(List<Participante> value) {
    _participante = value;
  }

  set situacao(Situacao value) {
    _situacao = value;
  }

  set motivo(Motivo value) {
    _motivo = value;
  }

  set valor(int value) {
    _valor = value;
  }

  set justificativaAdiantamento(String value) {
    _justificativaAdiantamento = value;
  }

  set dataEvento(DateTime value) {
    _dataEvento = value;
  }

  set id(int value) {
    _id = value;
  }

  Evento(this._id, this._dataEvento, this._justificativaAdiantamento,
      this._valor, this._motivo, this._situacao, this._participante);
}