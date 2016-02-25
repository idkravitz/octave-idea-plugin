package com.octaveide.psi;

import com.intellij.psi.tree.IElementType;
import com.octaveide.OctaveLanguage;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

public class OctaveElementType extends IElementType {

    public OctaveElementType(@NotNull @NonNls String debugName) {
        super(debugName, OctaveLanguage.INSTANCE);
    }
}
