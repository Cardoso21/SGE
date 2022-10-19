import 'package:flutter/material.dart';
import 'package:sge_app/models/participante.dart';

import '../../components/mensagens.dart';
import '../menuDrawer.dart';

class ListaParticipante extends StatelessWidget {

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('Clientes'),
      ),
      drawer: MenuDrawer(),
      floatingActionButton: FloatingActionButton.extended(
        onPressed: () {
          // Navigator.push(
          //   context,
          //   MaterialPageRoute(
          //     builder: (context) => Formulario(),
          //   ),
          // );
        },
        label: Text('Novo Clinete'),
        icon: Icon(Icons.person_rounded),
      ),
      body: FutureBuilder<List<Participante>>(
        // future: buscarTodosClientes(),
        builder: (context, snapshot) {
          switch (snapshot.connectionState) {
            case ConnectionState.none:
              break;
            case ConnectionState.waiting:

            case ConnectionState.active:
              break;
            case ConnectionState.done:
              if(snapshot.hasData){
                final List<Participante> clientes = snapshot.requireData;
                if (clientes.isNotEmpty) {
                  return Padding(
                    padding: const EdgeInsets.all(24),
                    child: ListView.separated(
                      shrinkWrap: true,
                      itemCount: clientes.length,
                      itemBuilder: (contextListView, indice) {
                        return ItemParticipante(clientes[indice]);
                      },
                      separatorBuilder: (BuildContext context, int index) =>
                      const Divider(),
                    ),
                  );
                }
              }
          }
          return CenteredMessage('Erro desconhecido!');
        },
      ),


    );
  }
}

class ItemParticipante extends StatelessWidget {
  final Participante participante;

  ItemParticipante(this.participante);

  @override
  Widget build(BuildContext context) {
    return Card(
      child: ListTile(
          leading: const Icon(Icons.people),
          title: Text(participante.nome),
          subtitle: Text('Pagamento: ' + participante.pagamento.toString())),
    );
  }
}
