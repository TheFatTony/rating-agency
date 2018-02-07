package com.chieftain.agency;

import com.chieftain.agency.transfer.NewsDto;
import junit.framework.TestCase;
import org.junit.Test;

public class AppTest extends TestCase {



    @Test
    public void testBean() {
        NewsDto myBean = new NewsDto();

        myBean.setAuthor("Author");
        myBean.setContent("Content");
        myBean.setLanguage("ru");

        assertEquals("Author", myBean.getAuthor());
        assertEquals("Content", myBean.getContent());
        assertEquals("ru", myBean.getLanguage());

    }

}
