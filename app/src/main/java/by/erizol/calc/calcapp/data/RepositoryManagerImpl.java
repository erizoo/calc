package by.erizol.calc.calcapp.data;

import javax.inject.Inject;

import by.erizol.calc.calcapp.data.network.ServiceNetwork;

public class RepositoryManagerImpl implements RepositoryManager {

    private ServiceNetwork serviceNetwork;


    @Inject
    RepositoryManagerImpl(ServiceNetwork serviceNetwork) {
        this.serviceNetwork = serviceNetwork;
    }

    @Override
    public ServiceNetwork getServiceNetwork() {
        return serviceNetwork;
    }
}
