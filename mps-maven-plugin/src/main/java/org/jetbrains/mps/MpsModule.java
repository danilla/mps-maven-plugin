package org.jetbrains.mps;

import com.google.common.collect.ImmutableList;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

class MpsModule {
    final List<File> libraries;

    private MpsModule(List<File> libraries) {
        this.libraries = libraries;
    }

    static MpsModule readFromFile(File root) {
        if (root.isFile()) {
            return new MpsModule(Collections.singletonList(root));
        }

        Collection<File> jarFiles = FileUtils.listFiles(root, new String[] {"jar"}, true);
        return new MpsModule(ImmutableList.copyOf(jarFiles));
    }
}
