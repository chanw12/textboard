package org.example;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    @Test
    public void testSetId(){
        FamousSaying fs = new FamousSaying();
        fs.setId(1);
        assertEquals(1,fs.getId());

    }
    @Test
    public void testSetText(){
        FamousSaying fs =new FamousSaying();
        fs.setF_text("하이");
        assertEquals("하이",fs.getF_text());
    }
    public void testSetAuthor(){
        FamousSaying fs =new FamousSaying();
        fs.setAuthor("찬우");
        assertEquals("찬우",fs.getAuthor());
    }
}