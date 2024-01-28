package org.example.config;

public class PortConfiguration {

    private static PortConfiguration portConfiguration;


    private PortConfiguration() {

    }

    public static PortConfiguration getInstance() {
        if (portConfiguration == null) {
            portConfiguration = new PortConfiguration();
        }
        return portConfiguration;
    }

}
