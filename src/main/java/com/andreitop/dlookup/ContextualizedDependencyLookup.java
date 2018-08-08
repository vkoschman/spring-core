package com.andreitop.dlookup;

public class ContextualizedDependencyLookup {

    interface ManagedComponent {
        void performLookup(Container container);
    }

    interface Container {
        Object getDependency(String id);
    }

    class CDL implements ManagedComponent {
        private Object dependency;

        public void performLookup(Container container) {
            this.dependency = container.getDependency("dependencyName");
        }
    }

}
