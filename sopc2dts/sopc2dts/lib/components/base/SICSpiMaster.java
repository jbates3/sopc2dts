/*
sopc2dts - Devicetree generation for Altera systems

Copyright (C) 2011 Walter Goossens <waltergoossens@home.nl>

This library is free software; you can redistribute it and/or
modify it under the terms of the GNU Lesser General Public
License as published by the Free Software Foundation; either
version 2.1 of the License, or (at your option) any later version.

This library is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
Lesser General Public License for more details.

You should have received a copy of the GNU Lesser General Public
License along with this library; if not, write to the Free Software
Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301  USA
*/
package sopc2dts.lib.components.base;

import sopc2dts.lib.BoardInfo;
import sopc2dts.lib.Connection;
import sopc2dts.lib.boardinfo.BICSpi;
import sopc2dts.lib.boardinfo.BoardInfoComponent;
import sopc2dts.lib.boardinfo.SpiSlave;
import sopc2dts.lib.components.BasicComponent;
import sopc2dts.lib.components.SopcComponentDescription;

public class SICSpiMaster extends BasicComponent {
	private static final long serialVersionUID = 5186841425372630796L;

	public SICSpiMaster(String cName, String iName, String ver, SopcComponentDescription scd) {
		super(cName, iName, ver, scd);
	}
	@Override
	public String toDtsExtras(BoardInfo bi, int indentLevel, Connection conn, Boolean endComponent)
	{
		String res = "";
		BoardInfoComponent bs = bi.getBicForChip(getInstanceName()); 
		if(bs!=null)
		{
			if(bs instanceof BICSpi)
			{
				BICSpi bSpi = (BICSpi)bs;
				for(SpiSlave slave : bSpi.getSlaves())
				{
					res += slave.toDts(indentLevel);
				}
			}
		}
		return res;
	}
}