/* ###
 * IP: GHIDRA
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package ghidra.app.plugin.core.debug.service.emulation;

import ghidra.app.services.TraceRecorder;
import ghidra.framework.plugintool.PluginTool;
import ghidra.trace.model.Trace;
import ghidra.util.classfinder.ExtensionPoint;

/**
 * A factory for configuring and creating a Debugger-integrated emulator
 *
 * <p>
 * See {@link BytesDebuggerPcodeEmulatorFactory} for the default implementation. See the Taint
 * Analyzer for the archetype of alternative implementations.
 */
public interface DebuggerPcodeEmulatorFactory extends ExtensionPoint {
	// TODO: Config options, use ModelFactory as a model

	/**
	 * Get the title, to appear in menus and dialogs
	 * 
	 * @return the title
	 */
	String getTitle();

	/**
	 * Create the emulator
	 * 
	 * @param tool the tool creating the emulator
	 * @param trace the user's current trace from which the emulator should load state
	 * @param snap the user's current snap from which the emulator should load state
	 * @param recorder if applicable, the recorder for the trace's live target
	 * @return the emulator
	 */
	DebuggerPcodeMachine<?> create(PluginTool tool, Trace trace, long snap,
			TraceRecorder recorder);
}
