package ru.kowkodivka.mindustry;

import arc.util.Log;
import mindustry.mod.Plugin;

@SuppressWarnings("unused")
public class Main extends Plugin {
    @Override
    public void init() {
        Log.info("Hello, world");
        Log.info(RustBridge.hello("lucin"));
    }
}