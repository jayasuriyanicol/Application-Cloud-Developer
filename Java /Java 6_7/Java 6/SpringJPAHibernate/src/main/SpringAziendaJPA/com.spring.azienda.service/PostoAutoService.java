package com.spring.azienda.service;

import java.util.List;

import com.spring.azienda.dto.PostoAutoDTO;
/* * PostoAutoService - Physical Asset Management Contract
    ? The final piece of the functional architecture, defining the management of corporate parking resources. This interface acts as the dedicated gateway for controlling physical inventory, ensuring that parking spots are tracked, allocated, and decommissioned according to company policy.

    ! 1. Resource Inventory Control, establishes a standardized set of operations for asset tracking. By defining 'inserisciPosto' and 'visualizzaPostiAuto', the interface ensures that the administration has a real-time view of available physical spaces, independent of the employees currently occupying them.
    ! 2. Safety-First Decommissioning, introduces the 'cancellaPostoAutoSeDipendenteExist' contract. This specific method signature signals a critical business rule: a physical asset cannot be removed from the database if it is currently linked to an active employee, preventing data inconsistency and "orphaned" foreign keys.
    ! 3. Granular Asset Lookup, provides a dedicated 'visualizzaPostoAuto' hook for targeted resource identification. This allows the system to retrieve specific location details (like "Sect. B, Row 4") by its unique ID, facilitating smooth logistics and
*/

public interface PostoAutoService  {
	
	public void inserisciPosto(PostoAutoDTO postoAuto);
	public List<PostoAutoDTO> visualizzaPostiAuto();
	public PostoAutoDTO visualizzaPostoAuto(Integer IdPostoAuto);
	public PostoAutoDTO cancellaPostoAutoSeDipendenteExist(Integer IdPostoAuto);
	
	

}