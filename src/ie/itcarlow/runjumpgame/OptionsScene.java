package ie.itcarlow.runjumpgame;

import ie.itcarlow.runjumpgame.SceneManager;
import ie.itcarlow.runjumpgame.SceneManager.SceneType;

import org.andengine.entity.scene.menu.MenuScene;
import org.andengine.entity.scene.menu.item.IMenuItem;
import org.andengine.entity.scene.menu.item.SpriteMenuItem;
import org.andengine.entity.scene.menu.item.decorator.ScaleMenuItemDecorator;

public class OptionsScene extends BaseScene implements MenuScene.IOnMenuItemClickListener {

	private MenuScene optionsScene;
	private final int CHANGE_PLAYER = 0;
	private final int BACK = 1;
	
	@Override
	public boolean onMenuItemClicked(MenuScene pMenuScene, IMenuItem pMenuItem, float pMenuItemLocalX, float pMenuItemLocalY) {
		switch(pMenuItem.getID())
		{
		case CHANGE_PLAYER:
		case BACK:
		    SceneManager.getInstance().loadMenuScene(engine);
		    disposeScene();
			return true;

		default:
			return false;
		}
	}

	@Override
	public void createScene() {
		createMenuChildScene();
	}

	@Override
	public void onBackKeyPressed() {
		SceneManager.getInstance().loadMenuScene(engine);
		
	}

	@Override
	public SceneType getSceneType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void disposeScene() {
		// TODO Auto-generated method stub
		
	}

	private void createMenuChildScene()
	{
		optionsScene = new MenuScene(camera);
		optionsScene.setPosition(0,0);
	    
	    final IMenuItem playMenuItem = new ScaleMenuItemDecorator(new SpriteMenuItem(CHANGE_PLAYER, resourcesManager.play_region, vbom), 1.2f, 1);
	    final IMenuItem optionsMenuItem = new ScaleMenuItemDecorator(new SpriteMenuItem(BACK, resourcesManager.options_region, vbom), 1.2f, 1);
	    
	    optionsScene.addMenuItem(playMenuItem);
	    optionsScene.addMenuItem(optionsMenuItem);
	    
	    optionsScene.buildAnimations();
	    optionsScene.setBackgroundEnabled(false);
	    
	    playMenuItem.setPosition(playMenuItem.getX(),playMenuItem.getY()-40);
		optionsMenuItem.setPosition(optionsMenuItem.getX(), optionsMenuItem.getY()-50);
	    
		optionsScene.setOnMenuItemClickListener(this);
	    
	    setChildScene(optionsScene);
	}
	
}
