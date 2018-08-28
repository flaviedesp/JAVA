
import java.math.BigDecimal;
import java.util.Date;
import java.sql.*;
import java.util.*;
import utilitairesMG.graphique.LF;
import utilitairesMG.jdbc.*;

public class Versement {

    private int numero;
    private Date date;
    private BigDecimal montant;
    private int numeroContact;
    private Contact contact;

// --------------------------------------------------------------------------
// GETERS
// --------------------------------------------------------------------------
    public int getNumero() throws SQLException {
        return numero;
    }

    public Date getDate() {
        return date;
    }

    public BigDecimal getMontant() {
        return montant;
    }

    public int getNumeroContact() {
        return numeroContact;
    }

    public Contact getContact() {
        return contact;
    }

    // --------------------------------------------------------------------------
// SETER
// --------------------------------------------------------------------------
    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setMontant(BigDecimal montant) {
        this.montant = montant;
    }

    public void setNumeroContact(int numeroContact) {
        this.numeroContact = numeroContact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }
}
