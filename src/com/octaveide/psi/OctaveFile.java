package com.octaveide.psi;

import com.intellij.extapi.psi.PsiFileBase;
import com.intellij.lang.Language;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;
import com.octaveide.OctaveFileType;
import com.octaveide.OctaveLanguage;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

public class OctaveFile extends PsiFileBase {

    public OctaveFile(@NotNull FileViewProvider fileViewProvider) {
        super(fileViewProvider, OctaveLanguage.INSTANCE);
    }

    @NotNull
    @Override
    public FileType getFileType() {
        return OctaveFileType.INSTANCE;
    }

    @Override
    public String toString() {
        return "Octave file";
    }

    @Override
    public Icon getIcon(int flags) {
        return super.getIcon(flags);
    }
}
