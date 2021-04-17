package com.cadenkoehl.zombieapocalypse.event.handler;

import com.cadenkoehl.zombieapocalypse.event.events.PlayerTickEvent;

import java.util.ArrayList;
import java.util.Arrays;

public abstract class EventListener {

    private static final ArrayList<EventListener> LISTENERS = new ArrayList<>();

    public static void registerEvents(EventListener... events) {
        LISTENERS.addAll(Arrays.asList(events));
    }

    public static ArrayList<EventListener> getListeners() {
        return LISTENERS;
    }

    public void onPlayerTick(PlayerTickEvent event) {}
}
