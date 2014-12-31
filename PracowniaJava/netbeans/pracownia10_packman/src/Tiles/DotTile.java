package Tiles;

import Sprites.Sprites;
import pacman.Screen;

public class DotTile extends Tile
{
    public DotTile(int p_id)
    {
        super(p_id);
        m_tile = Sprites.m_terrain[1][0];
    }
    
    public void render(int p_x, int p_y, Screen p_screen)
    {
        p_screen.renderSprite(p_x * m_tile.m_width, p_y * m_tile.m_height, m_tile);
    }
}
