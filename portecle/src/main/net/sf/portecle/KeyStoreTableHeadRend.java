/*
 * KeyStoreTableTypeHeadRend.java
 *
 * Copyright (C) 2004 Wayne Grant
 * waynedgrant@hotmail.com
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * (This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */

package net.sf.portecle;

import java.util.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;
import javax.swing.border.*;

/**
 * Custom cell renderer for the headers of the KeyStore table of FKeyToolGUI.
 */
class KeyStoreTableHeadRend extends DefaultTableCellRenderer
{
    /** Resource bundle */
    private static ResourceBundle m_res = ResourceBundle.getBundle("net/sf/portecle/resources");

    /**
     * Returns the rendered header cell for the supplied value and column.
     *
     * @param jtKeyStore The JTable
     * @param value The value to assign to the cell
     * @param bIsSelected True if cell is selected
     * @param iRow The row of the cell to render
     * @param iCol The column of the cell to render
     * @param bHasFocus If true, render cell appropriately
     ** @return The renderered cell
     */
    public Component getTableCellRendererComponent(JTable jtKeyStore, Object value,
                                                   boolean bIsSelected, boolean bHasFocus,
                                                   int iRow, int iCol)
    {
        // Get header renderer
        JLabel header = (JLabel)jtKeyStore.getColumnModel().getColumn(iCol).getHeaderRenderer();

        // The entry type header contains an icon
        if (iCol == 0)
        {
            header.setText("");
            ImageIcon icon = new ImageIcon(getClass().getResource(m_res.getString("KeyStoreTableHeadRend.TypeColumn.image")));
            header.setIcon(icon);
            header.setHorizontalAlignment(CENTER);
            header.setVerticalAlignment(CENTER);

            header.setToolTipText(m_res.getString("KeyStoreTableHeadRend.TypeColumn.tooltip"));
        }
        // The other headers contain text
        else
        {
            header.setText((String)value);
            header.setHorizontalAlignment(LEFT);

            if (iCol == 1)
            {
                header.setToolTipText(m_res.getString("KeyStoreTableHeadRend.AliasColumn.tooltip"));
            }
            else
            {
                header.setToolTipText(m_res.getString("KeyStoreTableHeadRend.LastModifiedDateColumn.tooltip"));
            }
        }

        header.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.RAISED), new EmptyBorder(0, 5, 0, 5)));

        return header;
    }
}