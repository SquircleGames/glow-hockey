package com.simei.glow;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.Filter;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.Shape;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.physics.box2d.joints.MouseJoint;
import com.badlogic.gdx.physics.box2d.joints.MouseJointDef;
import com.simei.bll.WorldListener;
import com.simei.util.Textures;
import com.stickycoding.rokon.PhysicalSprite;
import com.stickycoding.rokon.Scene;
import com.stickycoding.rokon.Sprite;
import com.stickycoding.rokon.Texture;
import com.stickycoding.rokon.background.FixedBackground;
/**
 * ��Ϸ����Ҫ�ĳ�����
 * @author KeTai
 *
 */
public class GameScene extends Scene {
	private Body playerBatBody;			//�˹�����
	private Body cpuBatBody;			//��������
	private Body ballBody;				//��
	
	private MouseJointDef mouseJointDef;  
	private MouseJoint mouserJoint;   //���ؽڣ������϶�����

	private FixtureDef virtualFixtureDef,realFixtureDef;		//һ������ʱ�Ķ���һ������ʵҪ�õĸ�����
	
	protected  static int  storeyNum = 3;	//һ�������ж��ٸ���
	protected  static int bodyNum = 20;	//һ��������ж��ٸ�����
	
	private PhysicalSprite[] walls;		//�����ܵ�ǽ�ڴ洢�������������

	private World world;
	
	
	 /**
	  * �޲ι���
	  */
	public GameScene(){
		super(storeyNum,bodyNum);	//����storeyNum���㣬ÿ�����bodyNum������
		setBackground(new FixedBackground(Textures.background)); 
		
		setWorld(world = new World(new Vector2(0, 0), true)); 
	
		world.setContactListener(new WorldListener()); //���ü��� 
		
		virtualFixtureDef = new FixtureDef();		//ʵ����������
		
		//�����洴�����ĺ���ĸ���
		playerBatBody = initBody(1f, 3.5f, 0.01f, 0.01f, 0.34f, Textures.playerBat, getRealFixtureDef(1f, 0f, false, 0f, new CircleShape()));
		
		Sprite sprit = new Sprite(1f, 2f, 0.3f, 0.3f);
		sprit.setTexture(Textures.playerBat);
		
		
		System.out.println(playerBatBody);
		
 		
		
		createWalls();
		 
	}
	
	/**
	 *	��ȡ��ʵ��FixtureDefʵ��
	 * @param density
 	 * @param friction
	 * @param isSensor	//��ô���false,����true�Ļ����������ײ��û��ײЧ�������
	 * @param restitution
	 * @param shape
	 * @return
	 */
	protected FixtureDef getRealFixtureDef(float density,float friction,boolean isSensor,float restitution,Shape shape) {
		FixtureDef fixtureDef = new FixtureDef();
		fixtureDef.density = density;
 		fixtureDef.friction = friction;
 		fixtureDef.isSensor = isSensor;
 		fixtureDef.shape  = shape; 
          
		return fixtureDef;
	}
	
	 
	
	/**
	 * ����body�������������Լ���
	 * @param x	����x
	 * @param y	����y
	 * @param width  ��
	 * @param height ��
	 * @param realFixtureDef ������
	 * @param radius �뾶
	 * @param texture ����
	 * @return
	 */
	
	protected Body initBody(float x,float y,float width,float height,float radius,Texture texture,FixtureDef realFixtureDef){
		if(virtualFixtureDef == null){
			virtualFixtureDef = new FixtureDef();
		}
		PhysicalSprite sprite = new PhysicalSprite(x, y, width, height);
		
		sprite.setTexture(texture); 
		add(2, sprite);
		sprite.createDynamicCircle(virtualFixtureDef); 
		sprite.body.setUserData(sprite);
		sprite.body.destroyFixture(sprite.body.getFixtureList().get(0));	//����֮ǰ�ĸ������Ϊ���ں������¹̶�body��СԲ������  
		
		realFixtureDef.shape.setRadius(radius);
		sprite.body.createFixture(realFixtureDef);  //����������ʵ��
		
		return sprite.body;
	}
	
	/**
	 * �������ܵ�ǽ�ڼ�����
	 */
	private void createWalls()
	{
		// Density(�ܶ�): 3.���� 4.�� 5.���£�������
		walls = new PhysicalSprite[10];
		// top
		initWall(0, -1, PlayActivity.getGameWidth() / 3,
				(float) (1 + 4.8 * 13 / 480), 0, 5);
		initWall(PlayActivity.getGameWidth() * 100 / 320, -1,
				PlayActivity.getGameWidth() / 3,
				(float) (1 + 4.8 * 13 / 480), 1, 4);
		initWall(PlayActivity.getGameWidth() * 220 / 320, -1,
				PlayActivity.getGameWidth() / 3,
				(float) (1 + 4.8 * 13 / 480), 2, 5);
		// right
		initWall(PlayActivity.getGameWidth() - (float) (3.2 * 13 / 320),
				0, (float) (3.2 * 13 / 320),
				PlayActivity.getGameHeight() / 2, 3, 3);
		initWall(PlayActivity.getGameWidth() - (float) (3.2 * 13 / 320),
				2.4f, (float) (3.2 * 13 / 320),
				PlayActivity.getGameHeight() / 2, 4, 3);
		// left
		initWall(-1, 0, (float) (1 + 3.2 * 12 / 320),
				PlayActivity.getGameHeight() / 2, 5, 3);
		initWall(-1, 2.4f, (float) (1 + 3.2 * 12 / 320),
				PlayActivity.getGameHeight() / 2, 6, 3);
		// bottom 1
		initWall(0,
				(float) (PlayActivity.getGameHeight() - 4.8 * 15 / 480),
				PlayActivity.getGameWidth()/3, (float) (4.8 * 15 / 480), 7,
				5);
		initWall(PlayActivity.getGameWidth() * 100 / 320,
				(float) (PlayActivity.getGameHeight() - 4.8 * 15 / 480),
				PlayActivity.getGameWidth()/3, (float) (4.8 * 15 / 480), 8,
				4);
		initWall(PlayActivity.getGameWidth() * 220 / 320,
				(float) (PlayActivity.getGameHeight() - 4.8 * 15 / 480),
				PlayActivity.getGameWidth()/3, (float) (4.8 * 15 / 480), 9,
				5);
	}
	
	/**
	 * ��������ǽ��
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 * @param i
	 * @param density
	 */
	private void initWall(float x, float y, float width, float height, int i,
			float density)
	{
		// top 1
		walls[i] = new PhysicalSprite(x, y, width, height);
		FixtureDef fixtureDef1 = new FixtureDef();
		fixtureDef1.density = density;
		fixtureDef1.friction = 0f;
		fixtureDef1.restitution = 1f;
		Shape shape = new PolygonShape();
		fixtureDef1.shape = shape;
		walls[i].createStaticBox(fixtureDef1);
		walls[i].setAlpha(0);
		add(0, walls[i]);
	}
	
	
	@Override
	public void onGameLoop() {
 		
	}

	@Override
	public void onPause() {
 		
	}

	@Override
	public void onReady() {
 		
	}

	@Override
	public void onResume() {
 		
	}

}
