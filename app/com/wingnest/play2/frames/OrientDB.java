/*
 * Copyright since 2013 Shigeru GOUGI (sgougi@gmail.com)
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
package com.wingnest.play2.frames;

import com.orientechnologies.orient.core.id.ORID;
import com.orientechnologies.orient.core.id.ORecordId;
import com.wingnest.play2.frames.plugin.orientdb.CustomIdManager;
import com.wingnest.play2.frames.plugin.orientdb.CustomIdManager.CustomIdHandler;

public class OrientDB {

	final private static CustomIdManager ID_MANAGER = new CustomIdManager();

	public static ORID fromCustomIdToORID(final String customId) {
		return new ORecordId(ID_MANAGER.decodeCustomId(customId));
	}

	public static String fromORIDToCustomId(final ORID orid) {
		return ID_MANAGER.encodeCustomId(orid);
	}

	public static CustomIdManager getCutomIdManager() {
		return ID_MANAGER;
	}

	public static void setCustomIdHandler(final CustomIdHandler handler) {
		getCutomIdManager().setCustomIdHandler(handler);
	}

	private OrientDB() {
	}

}
