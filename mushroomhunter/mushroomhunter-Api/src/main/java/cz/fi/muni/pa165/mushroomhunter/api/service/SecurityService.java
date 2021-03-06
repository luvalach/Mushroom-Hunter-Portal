/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.fi.muni.pa165.mushroomhunter.api.service;

import cz.fi.muni.pa165.mushroomhunter.api.dto.HunterDto;

/**
 *
 * @author Lukáš Valach
 */
public interface SecurityService {
    
    public HunterDto getCurrentlyLoggedUser();
    
    public boolean isCurrentlyLoggedUserAdmin();
    
    public boolean hasPermissionToModifyEntity(Long entityId);
}
