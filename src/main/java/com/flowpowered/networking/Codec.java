/*
 * This file is part of Flow Networking, licensed under the MIT License (MIT).
 *
 * Copyright (c) 2013 Spout LLC <http://www.spout.org/>
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.flowpowered.networking;

import io.netty.buffer.ByteBuf;

import java.io.IOException;

/**
 * {@code Codec}s are used to encode and decode a {@link Message} into a {@link ByteBuf}.
 */
public abstract class Codec<T extends Message> {
    private final Class<T> clazz;
    private int opcode;

    public Codec(Class<T> clazz, int opcode) {
        this.clazz = clazz;
        this.opcode = opcode;
    }

    public final Class<T> getMessage() {
        return clazz;
    }

    public final int getOpcode() {
        return opcode;
    }

    void setOpcode(int opcode) {
        this.opcode = opcode;
    }

    /**
     * Decodes a {@link ByteBuf} into a {@link Message}.
     *
     * @param buffer the buffer to read from
     * @return the message fully encoded.
     * @throws IOException If any decoding fails on the buffer
     */
    public abstract T decode(ByteBuf buffer) throws IOException;

    /**
     * Encodes a {@link Message} into a {@link ByteBuffer}.
     *
     * @param buf the buffer to encode into. Should be empty.
     * @param message The message to encode
     * @return A buffer ready to be sent
     * @throws IOException If any data on the message fails to encode
     */
    public abstract ByteBuf encode(ByteBuf buf, T message) throws IOException;
}