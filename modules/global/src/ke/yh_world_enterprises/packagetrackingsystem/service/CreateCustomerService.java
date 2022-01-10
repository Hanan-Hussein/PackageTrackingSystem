package ke.yh_world_enterprises.packagetrackingsystem.service;

import ke.yh_world_enterprises.packagetrackingsystem.entity.Admin;
import ke.yh_world_enterprises.packagetrackingsystem.entity.Customer;
import ke.yh_world_enterprises.packagetrackingsystem.wrappers.ResponseWrapper;

public interface CreateCustomerService {
    String NAME = "packagetrackingsystem_CreateCustomerService";
    ResponseWrapper createCustomer(Customer customer);


}