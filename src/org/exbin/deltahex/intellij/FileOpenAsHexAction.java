/*
 * Copyright (C) ExBin Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.exbin.deltahex.intellij;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.fileChooser.FileChooser;
import com.intellij.openapi.fileChooser.FileChooserDescriptor;
import com.intellij.openapi.fileEditor.FileEditor;
import com.intellij.openapi.fileEditor.FileEditorManager;
import com.intellij.openapi.fileEditor.OpenFileDescriptor;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;

import java.util.List;

/**
 * Open file in hexadecimal editor action.
 *
 * @author ExBin Project (http://exbin.org)
 * @version 0.1.3 2017/02/26
 */
public class FileOpenAsHexAction extends AnAction {

    public FileOpenAsHexAction() {
        super("Open As Hex...");
    }

    @Override
    public void actionPerformed(AnActionEvent event) {
        final Project project = event.getProject();
        if (project == null) {
            return;
        }

        FileChooserDescriptor chooserDescriptor = new FileChooserDescriptor(true, false, true, false, false, false);
        VirtualFile virtualFile = FileChooser.chooseFile(chooserDescriptor, project, null);
        if (virtualFile != null && virtualFile.isValid() && !virtualFile.isDirectory()) {
            DeltaHexVirtualFile deltaHexVirtualFile = new DeltaHexVirtualFile(virtualFile);
            OpenFileDescriptor descriptor = new OpenFileDescriptor(project, deltaHexVirtualFile, 0);
            List<FileEditor> editors = FileEditorManager.getInstance(project).openEditor(descriptor, true);
            DeltaHexFileEditor fileEditor = ((DeltaHexFileEditor) editors.get(0));
            fileEditor.openFile(deltaHexVirtualFile);
        }
    }
}