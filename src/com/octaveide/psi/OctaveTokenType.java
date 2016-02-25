package com.octaveide.psi;

import com.intellij.psi.tree.IElementType;
import com.octaveide.OctaveLanguage;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

public class OctaveTokenType extends IElementType {

    public OctaveTokenType(@NotNull @NonNls String debugName) {
        super(debugName, OctaveLanguage.INSTANCE);
    }

    @Override
    public String toString() {
        return "OctaveTokenType." + super.toString();
    }
}
