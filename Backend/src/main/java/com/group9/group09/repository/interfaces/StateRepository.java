package com.group9.group09.repository.interfaces;



import com.group9.group09.model.State;

import java.util.List;
import java.util.Optional;

public interface StateRepository {

    Optional<State> findByStateId(Integer stateID);
    Optional<State> findByStateName(String stateName);

    List<State> getStatesbyCountryID(Integer countrID);


}
