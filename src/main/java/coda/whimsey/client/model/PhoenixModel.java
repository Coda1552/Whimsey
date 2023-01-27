package coda.whimsey.client.model;

import coda.whimsey.common.entities.Phoenix;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;

public class PhoenixModel<T extends Phoenix> extends EntityModel<T> {
	private final ModelPart root;
	private final ModelPart body;
	private final ModelPart rightWing;
	private final ModelPart leftWing;
	private final ModelPart rightLeg;
	private final ModelPart rightFoot;
	private final ModelPart leftLeg;
	private final ModelPart leftFoot;
	private final ModelPart head;
	private final ModelPart tail;
	private final ModelPart tailTip;

	public PhoenixModel(ModelPart base) {
		this.root = base.getChild("root");
		this.body = root.getChild("body");
		this.rightWing = body.getChild("rightWing");
		this.leftWing = body.getChild("leftWing");
		this.rightLeg = root.getChild("rightLeg");
		this.rightFoot = rightLeg.getChild("rightFoot");
		this.leftLeg = root.getChild("leftLeg");
		this.leftFoot = leftLeg.getChild("leftFoot");
		this.head = body.getChild("head");
		this.tail = body.getChild("tail");
		this.tailTip = tail.getChild("tailTip");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition root = partdefinition.addOrReplaceChild("root", CubeListBuilder.create(), PartPose.offset(0.0F, 25.0F, 0.0F));

		PartDefinition body = root.addOrReplaceChild("body", CubeListBuilder.create().texOffs(30, 18).addBox(-5.0F, -19.0F, -6.0F, 10.0F, 9.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition head = body.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, -18.0F, 3.0F, 0.0F, 8.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(54, 43).addBox(-3.0F, -15.0F, -1.0F, 6.0F, 13.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(0, 52).addBox(-1.0F, -15.0F, -9.0F, 2.0F, 4.0F, 8.0F, new CubeDeformation(0.0F))
				.texOffs(10, 14).addBox(-1.0F, -11.0F, -9.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(0, 30).addBox(-3.0F, -7.0F, -5.0F, 6.0F, 9.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -15.0F, -4.0F));

		PartDefinition tail = body.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(0, 16).addBox(-7.0F, 0.0F, 0.0F, 14.0F, 0.0F, 18.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -16.0F, 10.0F, -0.7854F, 0.0F, 0.0F));

		PartDefinition tailTip = tail.addOrReplaceChild("tailTip", CubeListBuilder.create().texOffs(0, 0).addBox(-11.0F, 0.0F, 0.0F, 22.0F, 0.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 18.0F, 1.5708F, 0.0F, 0.0F));

		PartDefinition leftWing = body.addOrReplaceChild("leftWing", CubeListBuilder.create().texOffs(0, 25).mirror().addBox(0.0F, -6.0F, 1.0F, 0.0F, 9.0F, 18.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(22, 43).mirror().addBox(-1.0F, -4.0F, -1.0F, 2.0F, 7.0F, 14.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(6.0F, -15.0F, -3.0F, 0.0F, 0.0F, 0.0F));

		PartDefinition rightWing = body.addOrReplaceChild("rightWing", CubeListBuilder.create().texOffs(0, 25).mirror().addBox(0.0F, -6.0F, 1.0F, 0.0F, 9.0F, 18.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(22, 43).addBox(-1.0F, -4.0F, -1.0F, 2.0F, 7.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offset(-6.0F, -15.0F, -3.0F));

		PartDefinition rightLeg = root.addOrReplaceChild("rightLeg", CubeListBuilder.create().texOffs(12, 4).addBox(-1.0F, 0.0F, 0.0F, 2.0F, 9.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(-4.0F, -10.0F, 5.0F));

		PartDefinition rightFoot = rightLeg.addOrReplaceChild("rightFoot", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-3.0F, 0.0F, -4.0F, 6.0F, 0.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(0, 9).mirror().addBox(0.0F, -3.0F, -6.0F, 0.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 9.0F, 0.0F));

		PartDefinition leftLeg = root.addOrReplaceChild("leftLeg", CubeListBuilder.create().texOffs(12, 4).mirror().addBox(-1.0F, 0.0F, 0.0F, 2.0F, 9.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(4.0F, -10.0F, 5.0F));

		PartDefinition leftFoot = leftLeg.addOrReplaceChild("leftFoot", CubeListBuilder.create().texOffs(0, 9).mirror().addBox(0.0F, -3.0F, -6.0F, 0.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(0, 0).addBox(-3.0F, 0.0F, -4.0F, 6.0F, 0.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 9.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.head.xRot = headPitch * (Mth.PI / 180F);
		this.head.yRot = netHeadYaw * (Mth.PI / 180F);

		this.body.xRot = Mth.cos(ageInTicks * 0.3F) * 0.05F - 0.1F;
		this.body.y = Mth.sin(ageInTicks * 0.3F) * 0.4F;

		this.head.xRot += Mth.cos(ageInTicks * 0.3F + Mth.PI) * 0.05F + 0.1F;
		this.head.y = Mth.sin(ageInTicks * 0.3F) * 0.4F - 15.5F;

		this.leftWing.xRot = Mth.cos(ageInTicks * 0.3F) * 0.05F + 0.2F;
		this.leftWing.y = Mth.cos(ageInTicks * 0.3F) * 0.4F - 15.0F;

		this.rightWing.xRot = Mth.cos(ageInTicks * 0.3F) * 0.05F + 0.2F;
		this.rightWing.y = Mth.cos(ageInTicks * 0.3F) * 0.4F - 15.0F;

		this.tail.xRot = Mth.cos(ageInTicks * 0.3F) * 0.2F - 0.35F;
		this.tail.y = Mth.cos(ageInTicks * 0.3F) * 0.4F - 16.0F;

		this.tailTip.xRot = Mth.cos(1.0F - ageInTicks * 0.3F) * 0.15F + 0.675F;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		root.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}