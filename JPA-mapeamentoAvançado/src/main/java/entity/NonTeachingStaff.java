package entity;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;

@Entity
//@DiscriminatorValue( value = "NS" )
//@PrimaryKeyJoinColumn(referencedColumnName="sid")

public class NonTeachingStaff extends Staff {
    private String areaexpertise;

    public NonTeachingStaff(int sid, String sname, String areaexpertise) {
        super(sid, sname);
        this.areaexpertise = areaexpertise;
    }

    public NonTeachingStaff() {
        super();
    }

    public String getAreaexpertise() {
        return areaexpertise;
    }

    public void setAreaexpertise(String areaexpertise) {
        this.areaexpertise = areaexpertise;
    }
}
