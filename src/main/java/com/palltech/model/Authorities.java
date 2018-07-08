/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.palltech.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
/**
 *
 * @author Trinh
 */
@Entity
@Table(name = "AUTHORITIES")
public class Authorities {
    @Id
    @Column(name = "AUTHORITY")
    private String authority;
    @ManyToOne
    @JoinColumn(name = "USERNAME")
    private User user;

    //Getter and Setter methods
}
