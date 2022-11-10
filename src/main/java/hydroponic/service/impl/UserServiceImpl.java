package hydroponic.service.impl;

import hydroponic.dto.request.NewUserRequest;
import hydroponic.model.Address;
import hydroponic.model.Authority;
import hydroponic.model.Client;
import hydroponic.model.Customers;
import hydroponic.repository.AddressRepository;
import hydroponic.repository.AuthorityRepository;
import hydroponic.repository.CartRepository;
import hydroponic.repository.UserRepository;
import hydroponic.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private AuthorityRepository authorityRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public String createNewAccount(NewUserRequest newUserRequest) {
        ModelMapper modelMapper = new ModelMapper();
        Address address = modelMapper.map(newUserRequest, Address.class);
        if(newUserRequest.getIsClient()){
            Client client = modelMapper.map(newUserRequest, Client.class);
            client.setPassword(passwordEncoder.encode(newUserRequest.getPassword()));
            Authority authority = authorityRepository.findByRoleCode("CLIENT");
            if(authority == null){
                client.addAuthority().add(createAuthority("CLIENT", "Client Role"));
            }
            else{
                client.addAuthority().add(authority);
            }
            address.setUser(userRepository.save(client));
            addressRepository.save(address);
            return "New account created successfully...";
        }
        else{
            Customers customers = modelMapper.map(newUserRequest, Customers.class);
            customers.setPassword(passwordEncoder.encode(newUserRequest.getPassword()));
            Authority authority = authorityRepository.findByRoleCode("CUSTOMER");
            if(authority == null){
                customers.addAuthority().add(createAuthority("CUSTOMER", "Customer Role"));
            }
            else{
                customers.addAuthority().add(authority);
            }
            address.setUser(userRepository.save(customers));
            addressRepository.save(address);
            return "New account create successfully...";
        }
    }

    @Override
    public String updateUserRecord(NewUserRequest newUserRequest, int userId) {
        return null;
    }

    private Authority createAuthority(String roleCode,String roleDescription) {
        Authority authority=new Authority();
        authority.setRoleCode(roleCode);
        authority.setRoleDescription(roleDescription);
        return authorityRepository.save(authority);
    }
}
