package ua.co.k.workastmp;

import org.junit.Rule;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.Assert.*;

public class TmpFolderRuleTest {

    @Rule
    public TmpFolderRule tmpFolderRule = new TmpFolderRule();

    @Test
    @InTmpFolder
    public void testCanCreateAFile() throws IOException {
        // given
        IncludeContext context = tmpFolderRule.getContext();

        // when
        File file = context.writeFile("some.txt", "content");

        // then
        Files.exists(Paths.get(file.getAbsolutePath()));
    }
}