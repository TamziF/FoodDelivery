package com.example.fooddelivery.ioc.menu_fragment

import com.example.fooddelivery.databinding.FragmentMenuBinding
import com.example.fooddelivery.ui.view.menu.MenuFragmentViewController

class MenuFragmentViewComponent(
    binding: FragmentMenuBinding,
    fragmentComponent: MenuFragmentComponent
) {
    val viewController = MenuFragmentViewController(
        fragment = fragmentComponent.fragment,
        viewModel = fragmentComponent.viewModel,
        binding = binding
    )
}