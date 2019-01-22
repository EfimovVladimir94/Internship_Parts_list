package net.partsList.service;

import net.partsList.dao.PartsDao;
import net.partsList.model.Parts;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class PartsServiceImpl implements PartsService {
    private PartsDao partsDao;
    private int limitLines = 10;
    private int page = 0;
    private List<Parts> currentList = new ArrayList<>();
    List<Parts> editList = new ArrayList<>();

    public void setPartsDao(PartsDao partsDao) {
        this.partsDao = partsDao;
    }


    @Transactional
    public void addParts(Parts parts) {
        this.partsDao.addParts(parts);
        page = 0;
    }

    @Transactional
    public void updateParts(Parts parts) {
        this.partsDao.updateParts(parts);
        page = 0;
    }

    @Transactional
    public void removeParts(int id) {
        this.partsDao.removeParts(id);
        page = 0;
    }

    @Transactional
    public Parts getPartsById(int id) {
        return this.partsDao.getPartsById(id);
    }

    @Transactional
    public List<Parts> listParts(){
        if(page >= currentList.size()) return editList;
        editList.clear();
        for(int i = page; i < (page + limitLines); i++) {
            if(i < currentList.size()) editList.add(currentList.get(i));
        }
        page += limitLines;
        return editList;
    }

    @Transactional
    public List<Parts> currentList() {
        return currentList;
    }

    @Override
    public List getAllList() {
        return partsDao.listParts();
    }

    @Override
    public void redirectFrom() {
        page=0;
    }

    @Transactional
    public List<Parts> listNext() {
        return listParts();
    }

    @Transactional
    public void listPrevious() {
        int x = page - 2*limitLines;
        page= x < 0 ? 0 : x;
    }

    @Override
    public List list() {
        currentList = this.partsDao.listParts();
        return currentList;
    }

    @Transactional
    public List<Parts> selectNeed(){
        currentList.clear();
        List<Parts> list = this.partsDao.listParts();
        for(Parts parts : list) {
            if(parts.getNeed() == 1) currentList.add(parts);
        }
        page = 0;
        return currentList;
    }

    @Override
    public List<Parts> selectNoNeed() {
        currentList.clear();
        List<Parts> list = this.partsDao.listParts();
        for(Parts parts : list) {
            if(parts.getNeed() == 0) currentList.add(parts);
        }
        page = 0;
        return currentList;
    }

    @Override
    public int quantityComputer() {
        List<Parts> list = this.partsDao.listParts();
        List<Parts> needList = new ArrayList();
        for(Parts parts : list) {
            if(parts.getNeed() == 1) needList.add(parts);
        }
        int result = needList.get(0).getQuantity();
        for(Parts parts : needList) {
            if(result > parts.getQuantity()) result = parts.getQuantity();
        }
        return result;
    }

    @Override
    public Parts getPartByName(String name) {
        List<Parts> list = this.partsDao.listParts();
        for(Parts parts : list) {
            if(parts.getParts().equals(name)) return parts;
        }
        Parts parts = new Parts();
        parts.setParts("none");
        page = 0;
        return  parts;
    }
}
