package TD2;

import TD2.brokers.BrokerImplem;
import TD2.taches.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;

public class Manager {

    public static HashMap<String, BrokerImplem> arrayBrokers = null;
    public static List<Tache> rdvs = null;

    public Manager() {
        this.arrayBrokers = new HashMap<>();
        this.arrayBrokers.put("broker1", new BrokerImplem("broker1") );
        this.arrayBrokers.put("broker2", new BrokerImplem("broker2") );
        this.rdvs = new ArrayList<>();

    }

    public static void addRDV(Tache tache){
        rdvs.add( tache );
    }

    public Tache removeFirstRDV(){
        return this.rdvs.remove(0);
    }


    public static BrokerImplem getBroker(String name){
        return arrayBrokers.get(name);
    }

    public void start(){
        TacheA tacheA = new TacheA( "broker1", this.getBroker("broker1"));
        TacheB tacheB = new TacheB( "broker1", this.getBroker("broker1"));

        tacheA.start();
        tacheB.start();

    }

}
