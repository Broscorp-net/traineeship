package net.broscorp.oop.solid.dsp.wearings.work.remote;

import net.broscorp.oop.solid.dsp.*;

public class WearSuiteForRemoteWorkTest {

    public static void main(String[] args) {
        final AutoWearableSuite suite = new AutoWearableSuite(new Object[]{
                new LeftQuantumSock(),
                new RightQuantumSock(),
                new RedPants(),
        });

        suite.dressUp(new RemoteDeveloper());

        System.out.println("Remote Developer are ready to perform a code!");
    }

}
