package ke.yh_world_enterprises.packagetrackingsystem.service;

import ke.yh_world_enterprises.packagetrackingsystem.entity.Admin;
import ke.yh_world_enterprises.packagetrackingsystem.wrappers.ResponseWrapper;


public interface CreateAdminService {
    String NAME = "packagetrackingsystem_CreateAdminService";
    ResponseWrapper createAdmin(Admin admin);
}