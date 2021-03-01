package net.broscorp.oop.solid.dsp;

import net.broscorp.oop.solid.dsp.wearings.work.remote.LeftQuantumSock;
import net.broscorp.oop.solid.dsp.wearings.work.remote.RedPants;
import net.broscorp.oop.solid.dsp.wearings.work.remote.RightQuantumSock;

public class AutoWearableSuite {
    Object[] dress;

    public AutoWearableSuite(Object[] dress) {
        this.dress = dress;
    }

    public void dressUp(Human human) {
        for (Object wearing : dress) {
            if (wearing instanceof RedPants) addPants(human, (RedPants) wearing);
            if (wearing instanceof LeftQuantumSock) addSock(human, (LeftQuantumSock) wearing);
            if (wearing instanceof RightQuantumSock) addSock(human, (RightQuantumSock) wearing);
        }
    }

    void addPants(Human human, RedPants pants) {
        System.out.printf("Wearing Red Pants (%s) on Human (%s)", pants, human);
    }

    void addSock(Human human, LeftQuantumSock sock) {
        System.out.printf("Wearing Left Quantum Sock (%s) on Human (%s)", sock, human);
    }

    void addSock(Human human, RightQuantumSock sock) {
        System.out.printf("Wearing Right Quantum Sock (%s) on Human (%s)", sock, human);
    }
    
}

