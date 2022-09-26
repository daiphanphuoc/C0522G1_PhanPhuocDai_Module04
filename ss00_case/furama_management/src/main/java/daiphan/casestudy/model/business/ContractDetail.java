package daiphan.casestudy.model.business;


import daiphan.casestudy.model.facility.AttachFacility;

import javax.persistence.*;

@Entity
public class ContractDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "contract_id",referencedColumnName = "id")
    private Contract contract;

    @ManyToOne
    @JoinColumn(name = "attach_facility_id", referencedColumnName = "id")
    private AttachFacility  attachFacility;

    private int quantity;
    private boolean isDelete;

    public AttachFacility getAttachFacility() {
        return attachFacility;
    }

    public Contract getContract() {
        return contract;
    }

    public ContractDetail() {
    }


}
