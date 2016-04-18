/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.ibis1;

import com.mycompany.ibis1.nodes.Antecedent;
import com.mycompany.ibis1.relationship.LeftTreatment;
import com.mycompany.ibis1.relationship.MeetsCriteria;
import com.mycompany.ibis1.relationship.IsPartOfFamily;
import com.mycompany.ibis1.relationship.LivesIn;
import com.mycompany.ibis1.relationship.HasMotorExaminationSymptom;
import com.mycompany.ibis1.relationship.AreFamily;
import com.mycompany.ibis1.relationship.NotMeetsCriteria;
import com.mycompany.ibis1.relationship.HasNonMotorSymptom;
import com.mycompany.ibis1.relationship.HasTreatment;
import com.mycompany.ibis1.relationship.RemitsMotorExperienceSymptom;
import com.mycompany.ibis1.relationship.HasMotorComplicationSymptom;
import com.mycompany.ibis1.relationship.HasMotorExperienceSymptom;
import com.mycompany.ibis1.nodes.ParkinsonDisease;
import com.mycompany.ibis1.nodes.MotorComplicationsSymptom;
import com.mycompany.ibis1.nodes.Person;
import com.mycompany.ibis1.nodes.NonMotorSymptom;
import com.mycompany.ibis1.nodes.MotorExperiencesSymptom;
import com.mycompany.ibis1.nodes.Levodopa;
import com.mycompany.ibis1.nodes.Cie9;
import com.mycompany.ibis1.nodes.Family;
import com.mycompany.ibis1.nodes.Residence;
import com.mycompany.ibis1.nodes.ClinicalCriteria;
import com.mycompany.ibis1.nodes.MotorExaminationSymptom;
import com.mycompany.ibis1.nodes.Symptom;
import com.mycompany.ibis1.relationship.HasAntecedent;
import com.mycompany.ibis1.services.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import org.neo4j.ogm.session.Session;
import org.neo4j.ogm.session.SessionFactory;
import org.neo4j.ogm.session.result.Result;


@ManagedBean
public class Main {

    public static final String NEO4J_URL = "http://localhost:7474";
    public static final String USERNAME = "neo4j";
    public static final String PASSWORD = "neo";

    SimpleDateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy");

    public static Date parsedDate(String date) {

        Date parsedDate = null;
        SimpleDateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy");
        try {
            parsedDate = dateformat.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return parsedDate;
    }

    public void main() {
        // Create SessionFactory. Pass the package name of the entity classes as
        // the argument.

        SessionFactory sessionFactory = new SessionFactory("com.mycompany.ibis1");

        // Create the session
        Session session = sessionFactory.openSession(NEO4J_URL, USERNAME, PASSWORD);
        

        Iterable<Person> persons = session.query(Person.class, "MATCH (p:Person) return p", Collections.<String, Object>emptyMap());

        for (Person per : persons) {
            System.out.println(per.getName());
        }

        Person pepe = new Person();


 
        pepe.setId_person("10");
        pepe.setNhc("PRUEBA");
        pepe.setName("PRUEBA");
        session.save(pepe);
        
        
        PersonServiceImpl mario = new PersonServiceImpl();
        
         //= mario.getPerson();
        Session misesion = Neo4jSessionFactory.getInstance().getNeo4jSession();
        
        
        String query = "match n return n";
        Iterable<Map<String,Object>> personas =  Neo4jSessionFactory.getInstance().getNeo4jSession().query(query, Collections.EMPTY_MAP);
        
        
        
        
        System.out.println(personas);
        

        /*
        
        // Create 
        Person p = new Person();
        p.setId_person("1");
        p.setNhc("123456789");
        p.setName("Pepree");
        p.setFirst_surname("Lopez");
        p.setSecond_surname("Martinez");
        p.setGenre("Hombre");
        p.setDateOfBirth(parsedDate("02/02/1960"));
        p.setRace("Caucasico");
        p.setTelephone("999999999");
        
        
                session.save(p);
        
        Person p2 = new Person();
        p2.setId_person("2");
        p2.setNhc("111111111");
        p2.setName("Manuel");
        p2.setFirst_surname("Lopez");
        p2.setSecond_surname("Sanchez");
        p2.setGenre("Hombre");
        p2.setDateOfBirth(parsedDate("02/02/1935"));
        p2.setRace("Caucasico");
        p2.setTelephone("999999999");
        
        


        Residence residence = new Residence();
        residence.setAutonomousCommunity("AndalucÃƒÂ­a");
        residence.setProvince("Sevilla");
        residence.setLocation("Camas");
        
        LivesIn livesIn = new LivesIn();
        livesIn.setPerson(p);
        livesIn.setResidence(residence);
        
        AreFamily areFamily = new AreFamily();
        areFamily.setPerson1(p);
        areFamily.setPerson2(p2);
        areFamily.setRelation("Hijo");
        
        Family family = new Family();
        family.setFamilyId("F001");
        
        IsPartOfFamily ipf = new IsPartOfFamily();
        ipf.setPerson(p);
        ipf.setFamily(family);
        
        IsPartOfFamily ipf2 = new IsPartOfFamily();
        ipf2.setPerson(p2);
        ipf2.setFamily(family);
        
        
        ClinicalCriteria cc = new ClinicalCriteria();
        cc.setName("Criterio Clinico");
        cc.setComments("");
        
        Cie9 cie = new Cie9();
        cie.setName("CIE9");
        cie.setComments("");
            
        ParkinsonDisease pd = new ParkinsonDisease();
        pd.setName("Enfermedad de Parkinson");
        
        MeetsCriteria mc = new MeetsCriteria();
        mc.setPerson(p);
        mc.setCriterion(cc);
        mc.setDateCriteria(parsedDate("09/07/2005"));
        
        MeetsCriteria mc2 = new MeetsCriteria();
        mc2.setPerson(p);
        mc2.setCriterion(cie);
        mc2.setDateCriteria(parsedDate("10/05/2008"));
        
        NotMeetsCriteria nmc = new NotMeetsCriteria();
        nmc.setPerson(p);
        nmc.setCriterion(cie);
        nmc.setDateCriteria(parsedDate("09/07/2005"));
        
        cc.getCriteriaDiagnostic().add(pd);
        cie.getCriteriaDiagnostic().add(pd);
        
        NonMotorSymptom nms = new NonMotorSymptom();
        nms.setName("Daytime sleepiness");
        
        MotorExaminationSymptom mes = new MotorExaminationSymptom();
        mes.setName("Speech");
        
        MotorComplicationsSymptom mcs = new MotorComplicationsSymptom();
        mcs.setName("Time spent in the OFF state");
        
        MotorExperiencesSymptom mes2 = new MotorExperiencesSymptom();
        mes2.setName("Saliva and drooling");
        
        HasNonMotorSymptom hnms = new HasNonMotorSymptom();
        hnms.setPerson(p);
        hnms.setNonMotorSymptom(nms);
        hnms.setDateNonMotorSymptom(parsedDate("09/07/2005"));
        
        HasMotorComplicationSymptom hmcs = new HasMotorComplicationSymptom();
        hmcs.setPerson(p);
        hmcs.setMotorComplicationSymptom(mcs);
        hmcs.setDateMotorComplicationSymptom(parsedDate("09/07/2005"));
        
        HasMotorExaminationSymptom hmes = new HasMotorExaminationSymptom();
        hmes.setPerson(p);
        hmes.setMotorExaminationSymptom(mes);
        hmes.setDateMotorExaminationSymptom(parsedDate("09/07/2005"));
        
        HasMotorExperienceSymptom hmes2 = new HasMotorExperienceSymptom();
        hmes2.setPerson(p);
        hmes2.setMotorExperiencesSymptom(mes2);
        hmes2.setDateMotorExperiencesSymptom(parsedDate("09/07/2005"));
        
        RemitsMotorExperienceSymptom rmes = new RemitsMotorExperienceSymptom();
        rmes.setPerson(p);
        rmes.setMotorExperiencesSymptom(mes2);
        rmes.setDateMotorExperiencesSymptom(parsedDate("09/07/2010"));
        
        
        
        Levodopa lv = new Levodopa();
        lv.setName("Levodopa-carbibopa");
        
        HasTreatment ht = new HasTreatment();
        ht.setPerson(p);
        ht.setTreatment(lv);
        ht.setDateTreatment(parsedDate("10/10/2006"));
        
        LeftTreatment lt = new LeftTreatment();
        lt.setPerson(p);
        lt.setTreatment(lv);
        lt.setDateTreatment(parsedDate("01/01/2010"));
        
        Antecedent antecedent = new Antecedent();
        antecedent.setName("Alcoholismo");
        
        HasAntecedent ha = new HasAntecedent();
        ha.setPerson(p);
        ha.setAntecedent(antecedent);
        ha.setDateAntecedent(parsedDate("08/08/2000"));
        ha.setType("Personal");
        
        session.save(p);
        session.save(cie);
        session.save(cc);
        session.save(pd);
        session.save(mc);
        session.save(mc2);
        session.save(nmc);
        
        session.save(nms);
        session.save(hnms);
        session.save(mes);
        session.save(hmes);
        session.save(mcs);
        session.save(hmcs);
        session.save(mes2);
        session.save(hmes2);
        
        session.save(lv);
        session.save(ht);
        session.save(lt);
     
        session.save(rmes);
        session.save(areFamily);
        session.save(family);
        session.save(ipf);
        session.save(ipf2);
        
        session.save(residence);
        session.save(livesIn);
        
        session.save(antecedent);
        session.save(ha);
       
        
        
        //CONSULTAS
        
        //Personas
        Iterable<Person> persons = session.query(Person.class, "MATCH (p:Person) return p", Collections.<String, Object> emptyMap());
        
        for(Person per: persons){
            System.out.println(per.getName());
        }
        
        //Sintomas
        Iterable<Symptom> symptoms = session.query(Symptom.class, "MATCH (s:Symptom) return s", Collections.<String, Object> emptyMap());
        
        for(Symptom sym: symptoms){
            System.out.println(sym.getName());
        }
        
        
        //Distintas etiquetas
        Iterable<String> labels = session.query(String.class, "MATCH n RETURN DISTINCT labels(n)", Collections.<String, Object> emptyMap());
        
        System.out.println(labels.toString());
        
        //Distintas relaciones
        Iterable<String> relationships = session.query(String.class, "MATCH n-[r]-() RETURN DISTINCT type(r)", Collections.<String, Object> emptyMap());
        
        System.out.println(relationships.toString());
        
        
        //Etiquetas y sus relaciones
        Iterable<String> labelsAndRelationships = session.query(String.class, "MATCH n-[r]-() RETURN DISTINCT labels(n), type(r)", Collections.<String, Object> emptyMap());
        
        System.out.println(labelsAndRelationships.toString());
        
        
        //Nodos que no tengan relaciones
        Iterable<String> nodesAlone = session.query(String.class, "START n = node(*) MATCH n-[r?]-() WHERE r IS NULL RETURN n", Collections.<String, Object> emptyMap());
        
        System.out.println(nodesAlone.toString());
        

        //Nodos que tienen una propiedad especÃ­fica
        Iterable<Long> specificPropertyNodes = session.query(Long.class, "START n = node(*) MATCH n WHERE has(n.name) RETURN n", Collections.<String, Object> emptyMap());
        
        System.out.println(specificPropertyNodes.toString());
        
        //Nodos que tienen una relaciÃ³n especÃ­fica
        Iterable<String> specificRelationshipNodes = session.query(String.class, "START n = node(*) MATCH n-[:CRITERIA_DIAGNOSTIC]->() RETURN DISTINCT n", Collections.<String, Object> emptyMap());
        
        System.out.println(specificRelationshipNodes.toString());
        
       
        //Muestra los nodos y el nÃºmero de relaciones que tienen
        Iterable<String> countRelationshipsNodes = session.query(String.class, "START n = node(*) MATCH n-[r]-() RETURN n,count(r) AS rel_count ORDER BY rel_count DESC", Collections.<String, Object> emptyMap());
        
        System.out.println(countRelationshipsNodes.toString());
        
        
        //Nodos de una categorÃ­a y que tengan una propiedad especÃ­fica
        Iterable<Person> specificNodeForProperty = session.query(Person.class, "MATCH (n:Person) WHERE n.name='Pepe' RETURN n", Collections.<String, Object> emptyMap());
        
        for(Person per: specificNodeForProperty){
            System.out.println(per.getName());
        }
        
        //Nodos por id
        Iterable<String> nodesForId = session.query(String.class, "START n= node(1,2,3,4) RETURN n", Collections.<String, Object> emptyMap());
        
        System.out.println(nodesForId.toString());
        
        //Ver el id de un nodo Persona luego seleccionamos nodo por el id
        Iterable<String> nodeIdPerson = session.query(String.class, "MATCH (p:Person) WHERE p.nhc='123456789' RETURN id(p)", Collections.<String, Object> emptyMap());
        
        System.out.println("Prueba: " + nodeIdPerson.toString());
        
        String idPerson = nodeIdPerson.toString().substring(1, nodeIdPerson.toString().length() - 1);
        
        System.out.println("Prueba2: " + idPerson);
        
        //Relaciones de un tipo dado de un nodo concreto dado por un nhc
        Iterable<String> prueba = session.query(String.class, "START n = node("+ idPerson +") MATCH n-[r:MEETS_CRITERIA]->() RETURN r", Collections.<String, Object> emptyMap());
        
        System.out.println(prueba.toString());
        
        //Obtener los sintomas de una persona concreta dado su nhc
        Iterable<Symptom> personSymptoms= session.query(Symptom.class, "START n = node("+ idPerson +") MATCH n-[r]->(s:Symptom) RETURN s", Collections.<String, Object> emptyMap());
        
        for(Symptom sym: personSymptoms){
            System.out.println(sym.getName());
        }
        
         */

    }

}
