//package com.startup.repository.user.impl;

//import com.startup.entity.technician.Profession;
//import com.startup.entity.user.Role;
//import com.startup.factory.user.RoleFactory;
//import com.startup.repository.contact.AddressRepository;
//import com.startup.repository.contact.impl.AddressRepositoryImpl;
//import com.startup.repository.user.RoleRepository;

//import java.util.HashSet;
//import java.util.Set;
//@Deprecated
//public class RoleRepositoryImpl implements RoleRepository {
    //private static RoleRepository repository = null;
    //private Set<Role>roleDB;
    //public RoleRepositoryImpl(){
        //this.roleDB =new HashSet<>();
    //}

    //public static RoleRepository getRepository(){
       // if(repository == null)
           // repository = new RoleRepositoryImpl();
        //return repository;
   // }

   // @Override
   // public Set<Role> getAll() {
     //   return roleDB;
   // }

   // @Override
    //public Role create(Role role) {
        //this.roleDB.add(role);
       // return role;
   // }

   // @Override
    //public Role update(Role role) {
        //Role OldRole=read(role.getRoleId());
       // if(OldRole !=null){
          //  this.roleDB.remove(OldRole);
          //  this.roleDB.add(role);

    //    }

   //     return role;
   // }

   // @Override
    //public boolean delete(String s) {
      //  Role role = read(s);
       // if(role != null){
        //    this.roleDB.remove(role);
         //   return true;
       // }
       // return false;


   // }

   // @Override
   // public Role read(String roleId) {
      //  Role role= this.roleDB.stream()
         //       .filter(r -> r.getRoleId().equalsIgnoreCase(roleId) )
             //   .findAny()
           //     .orElse( null);

       // return role;
   // }
//}
