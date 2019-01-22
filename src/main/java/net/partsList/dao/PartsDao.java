package net.partsList.dao;
import net.partsList.model.Parts;
import java.util.List;

public interface PartsDao {
    public void addParts(Parts parts);
    public void updateParts(Parts parts);
    public void removeParts(int id);
    public Parts getPartsById(int id);
    public List<Parts> listParts();
}
