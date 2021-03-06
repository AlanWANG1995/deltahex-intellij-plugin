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
package org.exbin.deltahex.operation.swing;

import org.exbin.deltahex.CodeType;
import org.exbin.deltahex.operation.BinaryDataOperationException;
import org.exbin.deltahex.swing.CodeArea;
import org.exbin.utils.binary_data.EditableBinaryData;

/**
 * Operation for editing data in delete mode.
 *
 * @version 0.1.2 2017/01/02
 * @author ExBin Project (http://exbin.org)
 */
public class DeleteCodeEditDataOperation extends CodeEditDataOperation {

    private static final char BACKSPACE_CHAR = '\b';
    private static final char DELETE_CHAR = (char) 0x7f;

    private long position;
    private EditableBinaryData undoData = null;

    public DeleteCodeEditDataOperation(CodeArea codeArea, long startPosition) {
        super(codeArea);
        this.position = startPosition;
    }

    @Override
    public CodeAreaOperationType getType() {
        return CodeAreaOperationType.EDIT_DATA;
    }

    @Override
    public void execute() throws BinaryDataOperationException {
        execute(false);
    }

    @Override
    public CodeAreaOperation executeWithUndo() throws BinaryDataOperationException {
        return execute(true);
    }

    @Override
    public CodeType getCodeType() {
        return null;
    }

    private CodeAreaOperation execute(boolean withUndo) {
        throw new IllegalStateException("Cannot be executed");
    }

    @Override
    public void appendEdit(byte value) {
        EditableBinaryData data = (EditableBinaryData) codeArea.getData();
        switch (value) {
            case BACKSPACE_CHAR: {
                if (position > 0) {
                    position--;
                    if (undoData == null) {
                        undoData = (EditableBinaryData) data.copy(position, 1);
                    } else {
                        EditableBinaryData dataCopy = (EditableBinaryData) data.copy(position, 1);
                        undoData.insert(0, dataCopy);
                        dataCopy.dispose();
                    }
                    data.remove(position, 1);
                }
                break;
            }
            case DELETE_CHAR: {
                if (position < data.getDataSize()) {
                    if (undoData == null) {
                        undoData = (EditableBinaryData) data.copy(position, 1);
                    } else {
                        EditableBinaryData dataCopy = (EditableBinaryData) data.copy(position, 1);
                        undoData.insert(0, dataCopy);
                        dataCopy.dispose();
                    }
                    data.remove(position, 1);
                }
                break;
            }
            default: {
                throw new IllegalStateException("Unexpected character " + value);
            }
        }
        codeArea.getCaret().setCaretPosition(position);
        codeArea.repaint();
    }

    @Override
    public CodeAreaOperation[] generateUndo() {
        InsertDataOperation insertOperation = new InsertDataOperation(codeArea, position, 0, (EditableBinaryData) undoData.copy());
        return new CodeAreaOperation[]{insertOperation};
    }

    public long getPosition() {
        return position;
    }

    @Override
    public void dispose() throws BinaryDataOperationException {
        super.dispose();
        if (undoData != null) {
            undoData.dispose();
        }
    }
}
