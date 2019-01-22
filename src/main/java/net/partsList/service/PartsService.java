package net.partsList.service;

import net.partsList.model.Parts;

import java.util.List;

public interface PartsService {

    public void addParts(Parts parts);

    public void updateParts(Parts parts);

    public void removeParts(int id);

    public Parts getPartsById(int id);

    public List<Parts> listParts();

    public List<Parts> selectNeed();

    public List<Parts> selectNoNeed();

    public int quantityComputer();

    public Parts getPartByName(String name);

    public List<Parts> listNext();

    public void listPrevious();

    public List list();

    public List currentList();

    public List getAllList();

    public void redirectFrom();

}
