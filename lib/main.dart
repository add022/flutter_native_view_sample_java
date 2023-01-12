import 'package:flutter/material.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  // This widget is the root of your application.
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Flutter Demo',
      theme: ThemeData(
        primarySwatch: Colors.lime,
      ),
      home: const MyHomePage(title: 'Flutter Demo Home Page'),
    );
  }
}

class MyHomePage extends StatefulWidget {
  const MyHomePage({super.key, required this.title});

  final String title;

  @override
  State<MyHomePage> createState() => _MyHomePageState();
}

class _MyHomePageState extends State<MyHomePage> {
  bool _showNativeView = false;
  bool _useTexture = false;

  void _toggleNativeView(bool value) => setState(() => _showNativeView = value);
  void _toggleTextureInUse(bool value) => setState(() => _useTexture = value);

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text(widget.title),
      ),
      // backgroundColor: Colors.red,
      body: Center(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.start,
          children: <Widget>[
            SwitchListTile(
              title: const Text(
                'Toggle native view',
              ),
              value: _showNativeView,
              onChanged: _toggleNativeView,
            ),
            SwitchListTile(
              title: const Text(
                'Use texture',
              ),
              value: _useTexture,
              onChanged: _toggleTextureInUse,
            ),
            AspectRatio(aspectRatio: 1, child: _buildNativeViewWidget()),
          ],
        ),
      ),
    );
  }

  Widget _buildNativeViewWidget() {
    if (_showNativeView) {
      return Container(
        decoration: BoxDecoration(border: Border.all(color: Colors.blueAccent)),
        child: AndroidView(
            viewType:
                _useTexture ? 'texture_native_view' : 'surface_native_view'),
      );
    } else {
      return const SizedBox.expand();
    }
  }
}
