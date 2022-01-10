package ke.yh_world_enterprises.packagetrackingsystem.service;

import ke.yh_world_enterprises.packagetrackingsystem.entity.Package;
import ke.yh_world_enterprises.packagetrackingsystem.wrappers.ResponseWrapper;

public interface CreateOrderService {
    String NAME = "packagetrackingsystem_CreateOrderService";
    ResponseWrapper createOrder(Package pg);
}