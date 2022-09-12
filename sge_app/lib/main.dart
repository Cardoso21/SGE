import 'package:flutter/material.dart';
import 'package:sge_app/screens/dashboard.dart';

void main() {
  runApp( SgeApp());
}

class SgeApp extends StatelessWidget {

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      theme: ThemeData(
          colorScheme: ColorScheme.fromSwatch(
            primarySwatch: Colors.teal,
          ).copyWith(
            secondary: Color.fromARGB(95, 8, 234, 207),
          ),
          accentColor: Color.fromARGB(255, 142, 253, 236)),
       home: Dashboard(),
    );
  }
}
